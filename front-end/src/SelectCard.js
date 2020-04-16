import React from 'react';
import ScoreName from "./components/ScoreName";
import BlackCard from "./components/BlackCard";
import WhiteCard from "./components/WhiteCard";

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
            <div className="level-item">
                <WhiteCard label={item.cardMessage}/>
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

                <div class="level">
                    <div className="level-item">
                        <ScoreName label={"Big Jed"} value={0}/>
                    </div>

                    <div className="level-item">
                        <ScoreName label={"Owen Boi"} value={0}/>
                    </div>

                    <div className="level-item">
                        <ScoreName label={"Jack Nerd"} value={0}/>
                    </div>

                    <div className="level-item">
                        <ScoreName label={"Jeff Epstein"} value={0}/>
                    </div>
                </div>

                <div className="level">
                    <div className="level-item">
                        <BlackCard label="BLACK CARD TO BE FILLED WITH SILLY PROMPT"/>
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
        let value = "; " + document.cookie;
        let parts = value.split("; username=");
        if (parts.length === 2) {
            let username = parts.pop().split(";").shift().toString();
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
            }
        } else {
            console.log("Username didn't exist.")
        }
    }
}