import React from 'react'
import {NavBar} from "../Navbar";

const Home = () => {
    return (
        <div>
            <NavBar/>
            <section className="hero is-fullheight is-mobile has-background-dark">
                <div className="container has-text-centered" style={{marginTop: 5 + 'vh'}}>
                    <p className="has-text-light is-size-2">Cards Against Humanity Clone</p>
                    <div className="buttons is-centered are-medium" style={{marginTop: 5 + 'vh'}}>
                        <button className="button is-success">Create Game</button>
                        <button className="button is-info">Join Game</button>
                    </div>
                </div>
            </section>
        </div>
    )
}

export default Home;
