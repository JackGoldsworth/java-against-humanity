import React from 'react'

const axios = require('axios').default;

export default class WhiteCard extends React.Component {

    render() {
        return (
            <div className={'whiteCard'}>
                <button
                    className="button is-rounded is-white has-background-white has-text-black"> {this.props.label} </button>
            </div>
        );
    }
}