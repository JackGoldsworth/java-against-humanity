import React from 'react';
import ScoreName from "./ScoreName";
import BlackCard from "./BlackCard";
import {getUsername} from "../../AppUtils";

const axios = require('axios').default;

class CzarView extends React.Component {

    render() {
        let player = this.props.users.map(user => (
            <div className="level-item">
                <ScoreName label={user.username} value={user.points}/>
            </div>
        ))

        let cards = this.props.playedCards.map(item => (
            <div className={'whiteCard'}>
                <button
                    className="button is-rounded is-white has-background-white has-text-black" onClick={() => {
                    this.voteOnCard(item.cardMessage, this)
                }}> {item.cardMessage} </button>
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
                    <div className="level-left">
                        YOU ARE THE CZAR!
                    </div>
                </div>

                <div class="level">
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

    voteOnCard(message, bind) {
        let username = getUsername();

        let data = {
            username: username,
            cardMessage: message
        };

        if (username.toString()) {
            axios.post("http://localhost:8080/cards/vote",
                data,
                {headers: {"Content-Type": "application/json"}}
            ).then((response) => {
                console.log(response.data)
                bind.props.send(username)
            });
        }
    }
}

export default CzarView;