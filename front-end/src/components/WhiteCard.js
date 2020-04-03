import React from 'react'

const WhiteCard = (props) =>
{
    return(
        <div className={'whiteCard'}>
      <button className = "button is-rounded is-white has-background-white has-text-black"> {props.label} </button>
      </div>
    );
}
export default WhiteCard;