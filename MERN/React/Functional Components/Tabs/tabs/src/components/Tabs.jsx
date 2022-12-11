import React,{useState} from 'react'

const Tabs = (props) => {
const [index, setIndex] = useState(0);

const clickTab = (e, value) => {
        setIndex(value);
    }

function background1(e){
  e.target.style.background = 'White';
  e.target.style.color = 'Black';
}
function background2(e){
  e.target.style.background = 'Black';
  e.target.style.color = 'White';
}

const btn = {
  width:"5rem",
  height: "3rem",
  marginLeft: "1rem",

}

const contects={
  border: "0.05rem solid black",
  width: "20%",
  height:"7rem",
  margin: "0 auto",
}
  return (
    <div>
      {props.listOfTabs.map((item, index1) => {
        return(<button style={btn} key={index1} onMouseOut={background1} onMouseOver={background2} onClick={(e) => clickTab(e, index1)}>{item.name}</button>)
        
      }) }
      <hr></hr>
      <div>
        <h3 style={contects}>{props.listOfTabs[index].content}</h3>
      </div>
      
    </div>
  )
}

export default Tabs
