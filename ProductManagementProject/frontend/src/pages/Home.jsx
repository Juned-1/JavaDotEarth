import React, { useEffect, useState } from "react";
import axios from "axios";
import styles from "./Home.module.css";
import { useNavigate } from "react-router-dom";

const PLACEHOLDER_IMAGE = "data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMjcwIiBoZWlnaHQ9IjEwMCIgdmlld0JveD0iMCAwIDI3MCAxMDAiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+PHJlY3Qgd2lkdGg9IjI3MCIgaGVpZ2h0PSIxMDAiIGZpbGw9IiNlZWUiLz48dGV4dCB4PSI1MCUiIHk9IjUwJSIgZG9taW5hbnQtYmFzZWxpbmU9ImNlbnRyYWwiIGZvbnQtc2l6ZT0iMTJweCIgZmlsbD0iI2NjYyIgdGV4dC1hbmNob3I9Im1pZGRsZSI+Tm8gSW1hZ2U8L3RleHQ+PC9zdmc+";

const Home = () => {
  const [products, setProducts] = useState([]);
  const [images, setImages] = useState({});
  const [isError, setIsError] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/products");
        setProducts(response.data);

        // Fetch images for each product
        const imagePromises = response.data.map(async (product) => {
          try {
            const imgRes = await axios.get(
              `http://localhost:8080/api/product/${product.id}/image`,
              { responseType: "arraybuffer" }
            );
            const mimeType = imgRes.headers["content-type"];
            const base64 = btoa(
              new Uint8Array(imgRes.data).reduce(
                (data, byte) => data + String.fromCharCode(byte),
                ""
              )
            );
            return { id: product.id, src: `data:${mimeType};base64,${base64}` };
          } catch {
            return { id: product.id, src: PLACEHOLDER_IMAGE };
          }
        });

        const imagesArr = await Promise.all(imagePromises);
        const imagesObj = {};
        imagesArr.forEach((img) => {
          imagesObj[img.id] = img.src;
        });
        setImages(imagesObj);
      } catch (error) {
        console.error("Error fetching data:", error);
        setIsError(true);
      }
    };

    fetchData();
  }, []);

  if (isError) {
    return (
      <h2 className="text-center" style={{ padding: "10rem" }}>
        Something went wrong...
      </h2>
    );
  }

  return (
    <>
      <div className={styles.grid}>
        {products.map((product) => (
          <div
            className={styles.card}
            key={product.id}
            onClick={() => navigate(`/product/${product.id}`)}
            style={{ cursor: "pointer" }}
          >
            <img
              src={images[product.id] || PLACEHOLDER_IMAGE}
              alt={product.name}
              style={{
                width: "100%",
                height: "100px",
                objectFit: "cover",
                borderTopLeftRadius: "10px",
                borderTopRightRadius: "10px",
                background: "#eee"
              }}
            
            />
            <div className={styles["card-body"]}>
              <div>
                <h5 className={styles["card-title"]}>
                  {product.name.toUpperCase()}
                </h5>
                <i className={styles["card-brand"]}>
                  {"by " + product.brand}
                </i>
              </div>
              <hr className={styles["hr-line"]} />
              <div className={styles["home-cart-price"]}>
                <h5 className={styles["card-text"]}>
                  <i className="bi bi-currency-rupee"></i>
                  {product.price}
                </h5>
              </div>
              <button
                className={styles["btn-hover"]}
                onClick={e => {
                  e.stopPropagation();
                  navigate(`/product/${product.id}`);
                }}
              >
                View Details
              </button>
            </div>
          </div>
        ))}
      </div>
    </>
  );
};

export default Home;