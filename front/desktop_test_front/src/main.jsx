import React from 'react'
import ReactDOM from 'react-dom/client'

import './index.css'
import Home from './dashboards/Home.jsx'


import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import AddBook from './dashboards/AddBook.jsx';
import AddCategory from './dashboards/AddCategory.jsx';
import UpdateBook from './dashboards/UpdateBook.jsx';

const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
  },
  {
    path: "/cadastro-livros",
    element: <AddBook />,
  },
  {
    path: "/cadastro-categorias",
    element: <AddCategory />,
  },
  {
    path: "/cadastro-livros/:id",
    element: <UpdateBook />,
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>

    <RouterProvider router={router} />

  </React.StrictMode>,
)
