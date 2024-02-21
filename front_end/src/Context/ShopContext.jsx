import React, { createContext, useEffect, useState } from "react";

export const ShopContext = createContext(null);

const getDefaultCart = () => {
    let cart = {};
    for (let index = 0; index < 10; index++) {
        cart[index] = 0;
    }
    return cart;
}

const ShopContextProvider = (props) => {

    const [all_product, setAll_Product] = useState([]);
    console.log(all_product);

    const [cartItems, setCartItems] = useState(getDefaultCart());
    console.log(cartItems);

    useEffect(() => {
        fetch('http://localhost:8080/product/getAll')
            .then((response) => response.json())
            .then((data) => setAll_Product(data))

        if(localStorage.getItem('auth-token')){
            fetch('http://localhost:8080/cart/getAll',{
                method:'GET',
                headers:{
                    Accept:'application/json',
                    'auth_token':`${localStorage.getItem('auth-token')}`,
                    'Content-Type':'application/json',
                }
            }).then((response) => response.json())
            .then((data) => setCartItems(data))
        }
    }, []);

    const addToCart = (itemId) => {
        setCartItems((prev) => ({ ...prev, [itemId]: prev[itemId] + 1 }));
        if (localStorage.getItem('auth-token')) {
            fetch('http://localhost:8080/cart/add',{
                method:'POST',
                headers:{
                    Accept:'application/form-data',
                    'auth_token':`${localStorage.getItem('auth-token')}`,
                    'Content-Type':'application/json',
                },
                body:JSON.stringify({"product":itemId})
            })
        }
    }

    const removeFromCart = (itemId) => {
        setCartItems((prev) => ({ ...prev, [itemId]: prev[itemId] - 1 }));
        if (localStorage.getItem('auth-token')) {
            fetch('http://localhost:8080/cart/remove',{
                method:'POST',
                headers:{
                    Accept:'application/form-data',
                    'auth_token':`${localStorage.getItem('auth-token')}`,
                    'Content-Type':'application/json',
                },
                body:JSON.stringify({"product":itemId})
            })
        }
    }

    const getTotalCartAmount = () => {
        let totalAmount = 0;
        for (const item in cartItems) {
            if (cartItems[item] > 0) {
                let itemInfo = all_product.find((product) => product.id === Number(item));
                totalAmount += itemInfo.newPrice * cartItems[item];
            }
        }
        return totalAmount;
    }

    const getTotalCartItems = () => {
        let totalItem = 0;
        for (const item in cartItems) {
            if (cartItems[item] > 0) {
                totalItem += cartItems[item];
            }
        }
        return totalItem;
    }


    const contextValue = { all_product, cartItems, addToCart, removeFromCart, getTotalCartAmount, getTotalCartItems }

    return (
        <ShopContext.Provider value={contextValue}>
            {props.children}
        </ShopContext.Provider>
    )
}
export default ShopContextProvider;