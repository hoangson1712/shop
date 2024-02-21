import React, { useEffect, useState } from 'react'
import './Popular.css'
import { Item } from '../Item/Item'

export const Popular = () => {

    const [popularInWomen,setPopularInWomen] = useState([]);

    useEffect(() => {
      fetch('http://localhost:8080/product/popularinwomen')
      .then((response) => response.json())
      .then((data) => setPopularInWomen(data))
    },[]);

    return (
        <div className='popular'>
            <h1>POPULAR IN WOMEN</h1>
            <hr />
            <div className="popular-item">
                {popularInWomen.map((item, i) => {
                    return <Item key={i} id={item.id} name={item.name} image={item.image} new_price={item.newPrice} old_price={item.oldPrice} />
                })}
            </div>
        </div>
    )
}
