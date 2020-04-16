import React from 'react';
import {NavBar} from "./Navbar";
import {getPartyId} from "../AppUtils";

export class HostView extends React.Component {

    render() {
        return (
            <div>
                <NavBar/>
                <section className="hero is-fullheight is-mobile has-background-dark">
                    <div className="container has-text-centered" style={{marginTop: 5 + 'vh'}}>
                        <p className="has-text-light is-size-2">New Game</p>
                        <form>
                            <label className="has-text-light">
                                Base Pack
                                <input type="checkbox" id="basepack"/>
                            </label>
                            <br/>
                            <label className="has-text-light">
                                NSFW Pack
                                <input type="checkbox" id="nsfwpack"/>
                            </label>
                            <br/>
                            <label className="has-text-light">
                                Com Sci Pack
                                <input type="checkbox" id="cspack"/>
                            </label>
                            <br/><br/>
                            <label className="has-text-light">
                                Max Players:
                                <select id="maxplayers">
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                </select>
                            </label>
                            <br/><br/>
                            <label className="has-text-light">
                                Score to Win:
                                <select id="maxplayers">
                                    <option>3</option>
                                    <option>5</option>
                                    <option>7</option>
                                    <option>10</option>
                                </select>
                            </label>
                            <br/><br/>
                            <p className="has-text-light is-size-4" id="joinCode"/>
                            <br/><br/>
                            <button className="button is-success">Start</button>
                        </form>
                    </div>
                </section>
            </div>
        )
    }

    componentDidMount() {
        addJoinCode();
    }
}

/**
 * Renders the join code on the host view page.
 */
const addJoinCode = () => {
    document.getElementById("joinCode").innerText = "Join Code: " + getPartyId();
}
