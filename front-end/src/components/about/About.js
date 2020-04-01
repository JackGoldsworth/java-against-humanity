import React from 'react'
import {NavBar} from "../Navbar";

const axios = require('axios').default;

export class About extends React.Component {

    render() {
        return (
            <div className="has-background-dark">
                <NavBar/>

            </div>
        )
    }
}