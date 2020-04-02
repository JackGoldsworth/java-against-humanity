import React from 'react'

const BlackCard = (props) =>
{
    return(
        <div className={'blackCard'}>
            <input
                type = "button"
                value = {props.label}
            />
        </div>
    );
}
export default BlackCard;