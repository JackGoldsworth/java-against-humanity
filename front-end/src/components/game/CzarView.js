import React from 'react';
import ScoreName from "./ScoreName";
import BlackCard from "./BlackCard";
import {getUsername} from "../../AppUtils";
import {NavBar} from "../Navbar";

const axios = require('axios').default;

class CzarView extends React.Component {

    render() {
        if (this.props.winner != null) {
            return (
                <div>
                    <NavBar/>
                    <section className="hero is-fullheight is-mobile has-background-dark has-text-white">
                        <div className="container has-text-centered" style={{marginTop: 5 + 'vh'}}>
                            <p className="has-text-light is-size-2">{this.props.winner} has won the game!</p>
                        </div>
                    </section>
                </div>
            )
        } else {

            let player = this.props.users.map(user => (
                <div className="level-item">
                    <ScoreName label={user.username} value={user.points}/>
                </div>
            ))

            let cards = this.props.playedCards.map(item => (
                <div className={'whiteCard'}>
                    <textarea className="textarea has-background-white has-text-black" rows="8" readOnly
                              onClick={() => {
                                  this.voteOnCard(item.cardMessage, this)
                              }}>
                        {item.cardMessage}
                    </textarea>
                </div>
            ))

            return (
                <section className="hero is-fullheight is-mobile has-background-dark has-text-white">
                    <div class="level">
                        <div className="level-item">
                            <h1>Cards Against Humanity Clone</h1>
                        </div>
                    </div>

                    <div className="level-left has-text-centered">
                        YOU ARE THE CZAR!
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