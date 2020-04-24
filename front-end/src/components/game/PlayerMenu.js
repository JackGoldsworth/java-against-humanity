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
        this.setState({
            isCzar: false
        })
    }

    render() {
        this.connect(this)
        if (this.state.isCzar) {
            return <CzarView/>
        } else {
            return <SelectCard/>
        }
    }

    getCurrentCzar() {
        let username = getUsername()
        if (username) {
            axios.post("http://localhost:8080/parties/czar",
                username.toString(),
                {headers: {"Content-Type": "text/plain"}}
            ).then((response) => {
                console.log(response.data)
                if (response.status === 200) {
                    console.log("Successfully retrieved czar")
                    this.setState({isCzar: username === response.data});
                    this.forceUpdate()
                }
            });
        } else {
            console.log("Username didn't exist.")
        }
    }

    connect(bind) {
        let socket = new SockJS('/czar');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected');
            stompClient.subscribe('/results', function (messageOutput) {
                console.log(messageOutput.body);
                bind.getCurrentCzar()
            });
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