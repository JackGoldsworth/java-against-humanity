import React from 'react'
const axios = require('axios').default;

export class WhiteCard extends React.Component {


    render() {
        return (
            <div className={WhiteCard}>
                <View style = {styles.rectangle}>I am a white, answer card.</View>
            </div>
        )
    }
}

const styles = {

    rectangle: {
        width: '50px',
        height: '100px',
    }
}