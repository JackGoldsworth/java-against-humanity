import React from 'react'
import {NavBar} from "../Navbar";
import {useHistory} from "react-router-dom"

const Home = () => {
    return (
        <div>
            <NavBar/>
            <section className="hero is-fullheight is-mobile has-background-dark">
                <div className="container has-text-centered" style={{marginTop: 5 + 'vh'}}>
                    <p className="has-text-light is-size-2">Cards Against Humanity Clone</p>
                    <input id="username" className="input" type="text" style={{marginTop: 5 + 'vh', width: 23 + '%'}}
                           placeholder="Username"/>
                    <div className="buttons is-centered are-medium" style={{marginTop: 6 + 'vh'}}>
                        <button className="button is-success" onClick={setUsername}>Create Game</button>
                        <button className="button is-info" onClick={joinPartyMenu}>Join Game</button>
                    </div>
                </div>
            </section>
        </div>
    )
}

/**
 * This leads the user to the join party menu
 * as long as they've entered their username.
 */
const joinPartyMenu = () => {
    let username = document.getElementById("username").value;
    document.cookie = "username=" + username.toString();
    if (username) {
        window.location = "/join"
    } else {
        console.log("Please enter a username.")
    }
}

/**
 * This sets your username as a cookie.
 */
const setUsername = () => {
    let username = document.getElementById("username").value;
    console.log(username.toString())
    if (username.toString()) {
        document.cookie = "username=" + username.toString();
        window.location = "/hostview"
    } else {
        console.log("Please enter a username!")
    }
}

export default Home;