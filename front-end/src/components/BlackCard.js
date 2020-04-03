import React from 'react'

const BlackCard = (props) =>
{
    return(
        <div className={'blackCard'}>
            <textarea className= "textarea has-background-black has-text-white" rows = "8" readOnly>
                {props.label}
            </textarea>
        </div>
    );
}
export default BlackCard;