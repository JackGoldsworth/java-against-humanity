import React from 'react'
import {NavBar} from "../Navbar";

const Home = () => {
    return (
        <div>
            <NavBar/>
            <section className="hero is-fullheight is-mobile has-background-dark">
                <div className="container">
                    <p>Hello, World</p>
                </div>
            </section>
        </div>
    )
}

export default Home;
