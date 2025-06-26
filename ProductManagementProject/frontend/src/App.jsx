import './App.css';
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Home from "./pages/Home.jsx";
import AddProduct from "./pages/AddProduct/AddProduct.jsx";
import RootLayout from './pages/RootLayout.jsx';
import ProductDetails from './pages/ProductDetails/ProductDetails.jsx';
import UpdateProduct from './pages/UpdateProduct/UpdateProduct.jsx';

const route = createBrowserRouter([
  {path: "/", element: <RootLayout />,
    children: [
      {index: true, element: <Home />},
      {path: "add_product", element: <AddProduct />},
      {path: "product/:id", element: <ProductDetails />},
      {path: "product/:id/update", element: <UpdateProduct />},
    ]
  },
]);
function App() {
  return (

    <RouterProvider router={route} />
  )
}

export default App;
