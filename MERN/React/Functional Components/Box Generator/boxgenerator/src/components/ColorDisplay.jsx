import React,{useState} from 'react'

const ColorDisplay = (props) => {
    const boxStyle = {
        width:'5rem',
        height:'5rem',
        backgroundColor: props.theBox,
        border:'0.1rem solid black'
    }
    console.log(props);
      return (
    
    <div style={{display:'flex',justifyContent:'space-evenly'}}> 

        {props.theBox.map((item,i) => 
          <div key={i} style={{backgroundColor:item, width:'7rem',height:'7rem',border:'0.1rem solid black'  }}>{item}</div>
        )}
        {/* <p style={boxStyle}>{props.theColor}</p> */}
    </div>
      
  )
}

export default ColorDisplay
