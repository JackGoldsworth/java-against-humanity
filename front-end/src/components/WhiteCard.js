import React from 'react'

const WhiteCard = (props) =>
{
    return(
        <div className={'whiteCard'}>
      <input
          type = "button"
          value = {props.label}
      />
      </div>
    );
}
export default WhiteCard;