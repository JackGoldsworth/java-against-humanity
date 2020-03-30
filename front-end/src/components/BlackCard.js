import React from 'react'
const axios = require('axios').default;

export class BlackCard extends React.Component {


    render() {
        return (
            <div className={BlackCard}>
                <View style = {styles.rectangle}>I am a black, prompt card.</View>
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