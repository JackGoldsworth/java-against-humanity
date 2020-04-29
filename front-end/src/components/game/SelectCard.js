import React from 'react';
import ScoreName from "./ScoreName";
import BlackCard from "./BlackCard";
import {getUsername} from "../../AppUtils";

const axios = require('axios').default;

export default class SelectCard extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data: []
        }
    }

    render() {
        let cards = this.state.data.map(item => (
            <div className={'whiteCard'}>
                <button className="button is-rounded is-white has-background-white has-text-black" onClick={() => {
                    this.playCard(item.cardMessage, this)
                }}> {item.cardMessage} </button>
            </div>
        ))

        let player = this.props.users.map(user => (
            <div className="level-item">
                <ScoreName label={user.username}
                           value={user.points}

                />
            </div>
        ))

        return (
            <section className="hero is-fullheight is-mobile has-background-dark has-text-white">
                <div class="level">

                </div>
                <div class="level">
                    <div className="level-right">
                        <button className="button "> Back</button>
                    </div>
                    <div className="level-item">
                        <h1>Cards Against Humanity Clone</h1>
                    </div>
                </div>

                <div className="level">
                    {player}
                </div>

                <div className="level">
                    <div className="level-item">
                        <BlackCard label={this.props.blackCard}/>
                    </div>
                </div>

                <div class="level">
                    {cards}
                </div>
            </section>
        );
    }

    componentDidMount() {
        this.getUserCards();
    }

    getUserCards() {
        let username = getUsername()
        if (username) {
            axios.post("http://localhost:8080/cards/get",
                username.toString(),
                {headers: {"Content-Type": "text/plain"}}
            ).then((response) => {
                console.log(response.data)
                if (response.status === 200) {
                    console.log("Successfully retrieved cards")
                    this.setState({data: response.data});
                    this.forceUpdate()
                }
            });
        } else {
            console.log("Username didn't exist.")
        }
    }

    playCard(message, bind) {
        let username = getUsername();

        let data = {
            username: username,
            cardMessage: message
        };

        if (username.toString()) {
            axios.post("http://localhost:8080/cards/play",
                data,
                {headers: {"Content-Type": "application/json"}}
            ).then((response) => {
                console.log(response.data);
                bind.props.send(username)
            });
        }
    }
}