import React from 'react'
import {NavBar} from "../Navbar";

const Home = () => {
    return (
        <div>
            <NavBar/>
            <section className="hero is-fullheight is-mobile has-background-dark">
                <p className="has-text-light">Hello, World</p>
            </section>
        </div>
    )
}

export default Home;
