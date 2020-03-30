import React from 'react'
import {WhiteCard} from "./WhiteCard";
const axios = require('axios').default;

export class PlayerHand extends React.Component {


    render() {
        return (
            <div className={PlayerHand}>
                <WhiteCard />
                <WhiteCard />
                <WhiteCard />
                <WhiteCard />
            </div>
        )
    }
}