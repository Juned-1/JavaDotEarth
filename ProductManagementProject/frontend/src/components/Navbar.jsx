import React, { useEffect, useState, useRef } from "react";
import { FaSearch } from "react-icons/fa";
import axios from "axios";
import styles from "./Navbar.module.css";
import { Link, useNavigate } from "react-router-dom";

const Navbar = ({ onSelectCategory, onSearch }) => {
  const [search, setSearch] = useState("");
  const [results, setResults] = useState([]);
  const [showDropdown, setShowDropdown] = useState(false);
  const dropdownRef = useRef(null);
  const navigate = useNavigate();

  const getInitialTheme = () => {
    const storedTheme = localStorage.getItem("theme");
    return storedTheme ? storedTheme : "light-theme";
  };

  const [theme, setTheme] = useState(getInitialTheme());

  const toggleTheme = () => {
    const newTheme = theme === "dark-theme" ? "light-theme" : "dark-theme";
    setTheme(newTheme);
    localStorage.setItem("theme", newTheme);
  };

  useEffect(() => {
    document.body.className = theme;
  }, [theme]);

  // Hide dropdown when clicking outside
  useEffect(() => {
    function handleClickOutside(event) {
      if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
        setShowDropdown(false);
      }
    }
    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, []);

  const handleSearch = async () => {
    try {
      const res = await axios.get(
        `http://localhost:8080/api/product/search?keyword=${encodeURIComponent(search)}`
      );
      setResults(res.data || []);
      setShowDropdown(true);
      if (onSearch) onSearch(res.data);
    } catch (err) {
      alert("Search failed");
      setResults([]);
      setShowDropdown(false);
    }
  };

  const handleInputKeyDown = (e) => {
    if (e.key === "Enter") {
      e.preventDefault();
      handleSearch();
    }
  };

  const handleResultClick = (productId) => {
    setShowDropdown(false);
    setSearch("");
    setResults([]);
    navigate(`/product/${productId}`);
  };

  return (
    <>
      <header>
        <nav className={`navbar navbar-expand-lg fixed-top ${styles.navbar}`}>
          <div className="container-fluid">
            <Link className={styles["navbar-brand"]} to="/">
              ProductM
            </Link>
            <div className={styles["navbar-collapse"]}>
              <ul className={styles["navbar-nav"]}>
                <li className="nav-item">
                  <Link className={`nav-link ${styles["nav-link"]}`} to="/">
                    Home
                  </Link>
                </li>
                <li className="nav-item">
                  <Link
                    className={`nav-link ${styles["nav-link"]}`}
                    to="/add_product"
                  >
                    Add Product
                  </Link>
                </li>
                <li className="nav-item">
                  <Link
                    className={`nav-link dropdown-toggle ${styles["nav-link"]}`}
                    to="/"
                  >
                    Categories
                  </Link>
                </li>
              </ul>
              <div className={styles["right-section"]}>
                <button
                  className={`${styles["theme-toggle"]}`}
                  onClick={toggleTheme}
                  title={
                    theme === "dark-theme"
                      ? "Switch to light mode"
                      : "Switch to dark mode"
                  }
                >
                  <span className={styles["toggle-track"]}>
                    <span className={styles["toggle-icon"]}>
                      {theme === "dark-theme" ? "☀️" : "🌙"}
                    </span>
                    <span
                      className={styles["toggle-thumb"]}
                      style={{
                        left: theme === "dark-theme" ? "28px" : "2px",
                        background: theme === "dark-theme" ? "#ffd700" : "#22223b",
                      }}
                    />
                  </span>
                </button>
                <div className={styles.cart}>
                  <span style={{ fontSize: "1.2rem", marginRight: "0.5rem" }}>
                    🛒
                  </span>
                  Cart
                </div>
                <div
                  className={styles["search-container"]}
                  style={{ display: "flex", alignItems: "center", position: "relative" }}
                  ref={dropdownRef}
                >
                  <input
                    className={styles["form-control"]}
                    type="search"
                    placeholder="Search"
                    aria-label="Search"
                    value={search}
                    onChange={e => setSearch(e.target.value)}
                    onKeyDown={handleInputKeyDown}
                    style={{ paddingRight: search ? "4rem" : "2.5rem" }}
                    onFocus={() => results.length > 0 && setShowDropdown(true)}
                  />
                  <button
                    type="button"
                    className={styles["search-btn"]}
                    style={{
                      background: "none",
                      border: "none",
                      cursor: "pointer",
                      marginLeft: search ? "0.3rem" : "-2.2rem",
                      zIndex: 2,
                      color: "#563d7c"
                    }}
                    onClick={handleSearch}
                    aria-label="Search"
                  >
                    <FaSearch />
                  </button>
                  {showDropdown && results.length > 0 && (
                    <ul className={styles["search-dropdown"]}>
                      {results.map(product => (
                        <li
                          key={product.id}
                          className={styles["search-dropdown-item"]}
                          onClick={() => handleResultClick(product.id)}
                        >
                          {product.name}
                        </li>
                      ))}
                    </ul>
                  )}
                </div>
              </div>
            </div>
          </div>
        </nav>
      </header>
    </>
  );
};

export default Navbar;
