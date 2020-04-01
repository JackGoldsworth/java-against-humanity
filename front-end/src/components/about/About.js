import React from 'react'
import {NavBar} from "../Navbar";

const axios = require('axios').default;

export class About extends React.Component {

    render() {
        return (
            <div>
                <NavBar/>
                <section className="hero is-fullheight is-mobile has-background-dark">
                    <div className="container has-text-centered">
                        <div className="columns">
                            <div className="column">
                                <div className="notification is-green">
                                    <h1 className="title">What is Cards Against Humanity?</h1>
                                    <p className="is-size-5">
                                        Cards Against Humanity is a game about picking the funniest card.
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div className="columns">
                            <div className="column">
                                <div className="notification is-green">
                                    <h1 className="title">What is Cards Against Humanity?</h1>
                                    <p className="is-size-5">
                                        Cards Against Humanity is a game about picking the funniest card.
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div className="columns">
                            <div className="column">
                                <div className="notification is-green">
                                    <h1 className="title">What is Cards Against Humanity?</h1>
                                    <p className="is-size-5">
                                        Cards Against Humanity is a game about picking the funniest card.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        )
    }
}