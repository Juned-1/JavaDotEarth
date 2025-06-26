import React, { useEffect, useState, useRef } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import styles from "./UpdateProduct.module.css";

const UpdateProduct = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [product, setProduct] = useState({
    name: "",
    brand: "",
    category: "",
    price: "",
    available: false,
    quantity: "",
    releaseDate: "",
    description: "",
  });
  const [image, setImage] = useState(null);
  const [preview, setPreview] = useState(null);
  const [error, setError] = useState("");
  const fileInputRef = useRef(null);

  useEffect(() => {
    // Fetch current product details
    const fetchProduct = async () => {
      try {
        const res = await axios.get(`http://localhost:8080/api/product/${id}`);
        setProduct({
          ...res.data,
          releaseDate: res.data.releaseDate
            ? res.data.releaseDate.slice(0, 10)
            : "",
        });
        // Optionally fetch image for preview
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
          setPreview(`data:${mimeType};base64,${base64}`);
        } catch {
          setPreview(null);
        }
      } catch {
        setError("Failed to load product details.");
      }
    };
    fetchProduct();
  }, [id]);

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setProduct((prev) => ({
      ...prev,
      [name]: type === "checkbox" ? checked : value,
    }));
  };

  const handleImageChange = (e) => {
    const file = e.target.files[0];
    setImage(file);
    if (file) {
      setPreview(URL.createObjectURL(file));
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const formData = new FormData();
      formData.append(
        "product",
        new Blob([JSON.stringify(product)], { type: "application/json" })
      );
      // Always append imageFile, even if null
      formData.append("imageFile", image || new Blob());

      await axios.put(
        `http://localhost:8080/api/product/${id}`,
        formData,
        { headers: { "Content-Type": "multipart/form-data" } }
      );
      navigate(`/product/${id}`);
    } catch {
      setError("Failed to update product.");
    }
  };

  return (
    <div className={styles.container}>
      <form className={styles.form} onSubmit={handleSubmit}>
        <h2>Update Product</h2>
        {error && <div className={styles.error}>{error}</div>}
        <div className={styles.row}>
          <label>Name</label>
          <input
            className={styles.input}
            name="name"
            value={product.name}
            onChange={handleChange}
            required
          />
        </div>
        <div className={styles.row}>
          <label>Brand</label>
          <input
            className={styles.input}
            name="brand"
            value={product.brand}
            onChange={handleChange}
            required
          />
        </div>
        <div className={styles.row}>
          <label>Category</label>
          <input
            className={styles.input}
            name="category"
            value={product.category}
            onChange={handleChange}
            required
          />
        </div>
        <div className={styles.row}>
          <label>Price</label>
          <input
            className={styles.input}
            name="price"
            type="number"
            value={product.price}
            onChange={handleChange}
            required
          />
        </div>
        <div className={styles.row}>
          <label>
            <input
              name="available"
              type="checkbox"
              checked={product.available}
              onChange={handleChange}
            />
            Available
          </label>
        </div>
        <div className={styles.row}>
          <label>Quantity</label>
          <input
            className={styles.input}
            name="quantity"
            type="number"
            value={product.quantity}
            onChange={handleChange}
            required
          />
        </div>
        <div className={styles.row}>
          <label>Release Date</label>
          <input
            className={styles.input}
            name="releaseDate"
            type="date"
            value={product.releaseDate}
            onChange={handleChange}
          />
        </div>
        <div className={styles.row}>
          <label>Description</label>
          <textarea
            className={styles.textarea}
            name="description"
            value={product.description}
            onChange={handleChange}
            rows={3}
          />
        </div>
        <div className={styles.row}>
          <label>Product Image</label>
          <input
            type="file"
            accept="image/*"
            onChange={handleImageChange}
            ref={fileInputRef}
            style={{ display: "none" }}
          />
          <button
            type="button"
            className={styles.imageButton}
            onClick={() => fileInputRef.current && fileInputRef.current.click()}
          >
            Choose Image
          </button>
          {preview && (
            <img
              src={preview}
              alt="Preview"
              className={styles.imagePreview}
            />
          )}
        </div>
        <button className={styles.button} type="submit">
          Update Product
        </button>
      </form>
    </div>
  );
};

export default UpdateProduct;