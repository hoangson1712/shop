import React, { useEffect, useState } from 'react'
import './NewCollections.css'
import { Item } from '../Item/Item'

export const NewCollections = () => {

  const [new_collection,setNew_Collection] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/product/newcollections')
    .then((response) => response.json())
    .then((data) => setNew_Collection(data))
  },[])

  return (
    <div className='new-collections'>
      <h1>NEW COLLECTIONS</h1>
      <hr />
      <div className="collections">
        {new_collection.map((item,i)=>{
          return <Item key={i} id={item.id} name={item.name} image={item.image} new_price={item.newPrice} old_price={item.oldPrice} />
        })}
      </div>
    </div>
  )
}
