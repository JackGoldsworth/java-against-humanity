import React from 'react';
import {NavBar} from "../Navbar";

const axios = require('axios').default;

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
                            <button className="button is-success" onClick={joinParty}>Join Party
                            </button>
                        </div>
                    </div>
                </section>
            </div>
        )
    }
}

const joinParty = () => {
    let partyId = document.getElementById("partyId").value;
    let value = "; " + document.cookie;
    let parts = value.split("; username=");
    if (parts.length === 2) {
        let username = parts.pop().split(";").shift().toString();
        if (username) {
            let data = {
                username: username.toString(),
                id: partyId
            }
            if (partyId.toString()) {
                axios.post("http://localhost:8080/parties/join",
                    data,
                    {headers: {"Content-Type": "application/json"}}
                ).then((response) => {
                    if (response.status === 200) {
                        console.log("Party successfully Joined")
                    }
                    console.log(response.data)
                    window.location = "/playerMenu"
                });
            }
        } else {
            console.log("Please enter a username.")
        }
    }
}
