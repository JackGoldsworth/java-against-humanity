import React from 'react';
import {NavBar} from "../Navbar";

const axios = require('axios').default;
let stompClient = null;

export class JoinParty extends React.Component {
    render() {
        return (
            <div>
                <NavBar/>
                <section className="hero is-fullheight is-mobile has-background-dark">
                    <div className="container has-text-centered" style={{marginTop: 5 + 'vh'}}>
                        <p className="has-text-light is-size-3">Enter Join Code:</p>
                        <input id="partyId" className="input" type="text" style={{marginTop: 2 + 'vh', width: 23 + '%'}}
                               placeholder="Party ID"/>
                        <div className="buttons is-centered are-medium" style={{marginTop: 6 + 'vh'}}>
                            <button className="button is-success" onClick={() => this.joinParty(this)}>Join Party
                            </button>
                            <button className="button is-success" onClick={() => this.sendMessage("Test")}>Test
                            </button>
                        </div>
                    </div>
                </section>
            </div>
        )
    }
}