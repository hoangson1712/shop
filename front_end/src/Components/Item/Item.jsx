import React from 'react'
import './Item.css'
import { Link } from 'react-router-dom'

export const Item = (props) => {
  const link_img = 'http://localhost:8080/file/load/';
  const productId = props.id;
  return (
    <div className='item'>
      <Link to={'/product/'+ productId}><img onClick={window.scrollTo(0,0)} src={link_img+props.image} alt="" /></Link>
      <p>{props.name}</p>
      <div className="item-prices">
        <div className="item-price-new">
          ${props.new_price}
        </div>
        <div className="item-price-old">
          ${props.old_price}
        </div>
      </div>
    </div>
  )
}
