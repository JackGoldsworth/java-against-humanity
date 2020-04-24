import React from 'react'
import {NavBar} from "../Navbar";

export class About extends React.Component {

    render() {
        return (
            <div>
                <NavBar/>
                <section className="hero is-fullheight is-mobile has-background-dark">
                    <div className="container has-text-centered">
                        <div className="columns">
                            <div className="column">
                                <div className="notification is-info">
                                    <h1 className="title">What is Cards Against Humanity?</h1>
                                    <p className="is-size-5">
                                        Cards Against Humanity is a game about matching the funniest cards
                                        to a prompt. Then a the Card Czar picks the best card of the bunch and you
                                        get a point.
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div className="columns">
                            <div className="column">
                                <div className="notification is-green">
                                    <h1 className="title">Rules</h1>
                                    <p className="is-size-5">
                                        The first one to reach the set amount of points by the host wins. You will
                                        receive one new card per round,
                                        but you must also get rid of one card per round. On the round that you are the
                                        card czar, this will not apply.
                                        Now try to be the funniest, and go out there and have some fun!
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