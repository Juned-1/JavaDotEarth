import React, { useState, useRef } from "react";
import axios from "axios";
import styles from "./AddProduct.module.css";
import { useNavigate } from "react-router-dom";

const initialState = {
  name: "",
  description: "",
  price: "",
  brand: "",
  category: "",
  releaseDate: "",
  available: false,
  quantity: "",
  image: null,
};

const AddProduct = () => {
  const [form, setForm] = useState(initialState);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");
  const [imagePreview, setImagePreview] = useState(null);
  const fileInputRef = useRef(null);
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value, type, checked, files } = e.target;
    if (type === "checkbox") {
      setForm({ ...form, [name]: checked });
    } else if (type === "file") {
      const file = files[0];
      setForm({ ...form, image: file });
      if (file) {
        const reader = new FileReader();
        reader.onloadend = () => setImagePreview(reader.result);
        reader.readAsDataURL(file);
      } else {
        setImagePreview(null);
      }
    } else {
      setForm({ ...form, [name]: value });
    }
  };

  const handleImageButtonClick = (e) => {
    e.preventDefault();
    fileInputRef.current.click();
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError("");
    try {
      const formData = new FormData();
      const { image, ...productData } = form;
      // Send product as a Blob with application/json type
      const productBlob = new Blob([JSON.stringify(productData)], { type: "application/json" });
      formData.append("product", productBlob);
      if (image) {
        formData.append("imageFile", image);
      }
      await axios.post("http://localhost:8080/api/product", formData, {
        headers: { "Content-Type": "multipart/form-data" },
      });
      navigate("/");
    } catch (err) {
      setError("Failed to add product. Please try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className={styles.container}>
      <form
        className={styles.form}
        onSubmit={handleSubmit}
        encType="multipart/form-data"
      >
        <h2 className={styles.title}>Add New Product</h2>
        {error && <div className={styles.error}>{error}</div>}
        <div className={styles.row}>
          <label>Name</label>
          <input
            name="name"
            type="text"
            value={form.name}
            onChange={handleChange}
            required
            className={styles.input}
          />
        </div>
        <div className={styles.row}>
          <label>Description</label>
          <textarea
            name="description"
            value={form.description}
            onChange={handleChange}
            required
            className={styles.textarea}
          />
        </div>
        <div className={styles.row}>
          <label>Price</label>
          <input
            name="price"
            type="number"
            min="0"
            step="0.01"
            value={form.price}
            onChange={handleChange}
            required
            className={styles.input}
          />
        </div>
        <div className={styles.row}>
          <label>Brand</label>
          <input
            name="brand"
            type="text"
            value={form.brand}
            onChange={handleChange}
            required
            className={styles.input}
          />
        </div>
        <div className={styles.row}>
          <label>Category</label>
          <select
            name="category"
            value={form.category}
            onChange={handleChange}
            required
            className={styles.input}
          >
            <option value="">Select Category</option>
            <option value="Electronic">Electronic</option>
            <option value="Grocery">Grocery</option>
            <option value="Motor">Motor</option>
            <option value="Clothing">Clothing</option>
            <option value="Books">Books</option>
            <option value="Home">Home</option>
            <option value="Toys">Toys</option>
            <option value="Sports">Sports</option>
            <option value="Beauty">Beauty</option>
            <option value="Other">Other</option>
          </select>
        </div>
        <div className={styles.row}>
          <label>Release Date</label>
          <input
            name="releaseDate"
            type="date"
            value={form.releaseDate}
            onChange={handleChange}
            className={styles.input}
          />
        </div>
        <div className={styles.row}>
          <label>
            <input
              name="available"
              type="checkbox"
              checked={form.available}
              onChange={handleChange}
            />
            &nbsp;Available
          </label>
        </div>
        <div className={styles.row}>
          <label>Quantity</label>
          <input
            name="quantity"
            type="number"
            min="0"
            value={form.quantity}
            onChange={handleChange}
            required
            className={styles.input}
          />
        </div>
        <div className={styles.row}>
          <label>Image</label>
          <input
            ref={fileInputRef}
            name="image"
            type="file"
            accept="image/*"
            onChange={handleChange}
            style={{ display: "none" }}
          />
          <button
            className={styles.imageButton}
            onClick={handleImageButtonClick}
            type="button"
          >
            {form.image ? "Change Image" : "Choose Image"}
          </button>
          {imagePreview && (
            <div className={styles.imagePreviewWrapper}>
              <img
                src={imagePreview}
                alt="Preview"
                className={styles.imagePreview}
              />
            </div>
          )}
        </div>
        <button className={styles.button} type="submit" disabled={loading}>
          {loading ? "Adding..." : "Add Product"}
        </button>
      </form>
    </div>
  );
};

export default AddProduct;
