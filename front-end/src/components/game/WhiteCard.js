import React from 'react'

const axios = require('axios').default;


const WhiteCard = (props) =>
{
    return(
        <div className={'whiteCard'}>
      <button className = "button is-rounded is-white has-background-white has-text-black" onClick={sendContent}> {props.label} </button>
      </div>
    );
}

//this function is called by each whiteCard button and sends the content of the card to the server via axios
const sendContent = () =>
{
    let content = this.props.label
    console.log(content)

    axios.post("http://localhost:8080/game/cardContent", null,
        {headers: {"Content-Type": "application/json"}})
        .then((response) =>
        {
            if(response.status === 200)
            {
                console.log("Card successfully sent to server.")
            }
        });

}

export default WhiteCard;