import React from 'react';
import CzarView from "./CzarView";
import SelectCard from "./SelectCard";
import {getUsername} from "../../AppUtils";
import * as SockJS from "sockjs-client";
import * as Stomp from "stompjs";

let stompClient = null;

const axios = require('axios').default;

class PlayerMenu extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            isCzar: false,
            czar: "",
            blackCard: "",
            users: [],
            playedCards: [],
            winner: null
        }
    }

    render() {
        if (this.state.isCzar) {
            return <CzarView
                host={this.state.host}
                blackCard={this.state.blackCard}
                users={this.state.users}
                send={this.sendMessage}
                playedCards={this.state.playedCards}
                winner={this.state.winner}
            />
        } else {
            return <SelectCard
                host={this.state.host}
                blackCard={this.state.blackCard}
                users={this.state.users}
                send={this.sendMessage}
                winner={this.state.winner}
            />
        }
    }

    componentDidMount() {
        this.connect(this)
    }

    connect(bind) {
        let socket = new SockJS('/czar');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected');
            stompClient.subscribe('/results', function (messageOutput) {
                let body = JSON.parse(messageOutput.body)
                body = body.body
                console.log(body)
                let winner = null;
                if (body.winner != null) {
                    winner = body.winner.username
                    axios.post("http://localhost:8080/parties/disband",
                        getUsername(),
                        {headers: {"Content-Type": "application/json"}}
                    )
                }

                bind.setState({
                    isCzar: getUsername() === body.czar,
                    czar: body.czar,
                    blackCard: body.blackCard.cardMessage,
                    users: body.users,
                    playedCards: body.playedCards,
                    winner: winner
                });
            });
            bind.sendMessage(getUsername())
        });
    }

    sendMessage(message) {
        stompClient.send("/czar", {}, message);
    }

    componentWillUnmount() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        console.log("Disconnected");
    }
}

export default PlayerMenu;