import React from 'react';
import CzarView from "./CzarView";
import SelectCard from "./SelectCard";
import {getUsername} from "../../AppUtils";
import * as SockJS from "sockjs-client";
import * as Stomp from "stompjs";

let stompClient = null;

class PlayerMenu extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            isCzar: false,
            czar: "",
            blackCard: "",
            users: [],
            playedCards: []
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
            />
        } else {
            return <SelectCard
                host={this.state.host}
                blackCard={this.state.blackCard}
                users={this.state.users}
                send={this.sendMessage}
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
                bind.setState({
                    isCzar: getUsername() === body.czar,
                    czar: body.czar,
                    blackCard: body.blackCard.cardMessage,
                    users: body.users,
                    playedCards: body.playedCards
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