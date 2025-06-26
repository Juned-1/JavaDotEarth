import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import styles from "./ProductDetails.module.css";

const ProductDetails = () => {
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const [image, setImage] = useState(null);
  const [isError, setIsError] = useState(false);
  const [theme, setTheme] = useState(document.body.className);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchProduct = async () => {
      try {
        const res = await axios.get(`http://localhost:8080/api/product/${id}`);
        setProduct(res.data);

        // Fetch image after product is fetched
        try {
          const imgRes = await axios.get(
            `http://localhost:8080/api/product/${id}/image`,
            { responseType: "arraybuffer" }
          );
          const mimeType = imgRes.headers["content-type"];
          const base64 = btoa(
            new Uint8Array(imgRes.data).reduce(
              (data, byte) => data + String.fromCharCode(byte),
              ""
            )
          );
          setImage(`data:${mimeType};base64,${base64}`);
        } catch {
          setImage(null); // No image found, do not set
        }
      } catch (err) {
        setIsError(true);
      }
    };
    fetchProduct();
  }, [id]);

  if (isError) {
    return (
      <div className={styles.centered}>
        <h2>Product not found or error loading product.</h2>
      </div>
    );
  }

  if (!product) {
    return (
      <div className={styles.centered}>
        <div className={styles.loader}></div>
      </div>
    );
  }

  //handle delete product
  const handleDelete = async () => {
    if(window.confirm("Are you sure you want to delete this product?")) {
      try{
        await axios.delete(`http://localhost:8080/api/product/${id}`);
        navigate("/");
      }catch (error) {
        alert("Failed to delete product.");
      }
    }
  };

  //handle for update
  const handleUpdate = () => {
    navigate(`/product/${id}/update`);
  }

  return (
    <div className={`${styles.container} ${theme === "dark-theme" ? styles.dark : ""}`}>
      <div className={styles.card}>
        <div className={styles.header}>
          <h2 className={styles.title}>{product.name}</h2>
          <span className={styles.brand}>by {product.brand}</span>
        </div>
        <hr className={styles.hr} />
        {image && (
          <div className={styles.imageWrapper}>
            <img
              src={image}
              alt={product.name}
              className={styles.productImage}
              style={{ width: "100%", maxHeight: "200px", objectFit: "cover", borderRadius: "8px" }}
            />
          </div>
        )}
        <div className={styles.details}>
          <div className={styles.row}>
            <span className={styles.label}>Category:</span>
            <span className={styles.stdetails}>{product.category}</span>
          </div>
          <div className={styles.row}>
            <span className={styles.label}>Price:</span>
            <span className={styles.price}>
              <i className="bi bi-currency-rupee"></i>
              {product.price}
            </span>
          </div>
          <div className={styles.row}>
            <span className={styles.label}>Available:</span>
            <span className={styles.stdetails}>{product.available ? "In Stock" : "Out of Stock"}</span>
          </div>
          <div className={styles.row}>
            <span className={styles.label}>Quantity:</span>
            <span className={styles.stdetails}>{product.quantity}</span>
          </div>
          <div className={styles.row}>
            <span className={styles.label}>Release Date:</span>
            <span className={styles.stdetails}>
              {product.releaseDate ?
                new Date(product.releaseDate).toLocaleDateString()
                : "N/A"
              }
            </span>
          </div>
        </div>
        <div className={styles.description}>
          <h4>Description</h4>
          <p>{product.description}</p>
        </div>
        <button className={styles.btn} disabled={!product.available}>Add to Cart</button>
        <div style={{ display: "flex", gap: "10px", marginTop: "20px" }}>
          <button className={styles.btn} onClick={handleUpdate}>Update</button>
          <button className={styles.btn} style={{ background: "#e74c3c" }} onClick={handleDelete}>
            Delete
          </button>
        </div>
      </div>
    </div>
  );
};

export default ProductDetails;