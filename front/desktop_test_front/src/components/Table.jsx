import { useEffect, useState } from 'react'

import DataTable from 'react-data-table-component';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrash } from '@fortawesome/free-solid-svg-icons';
import axios from "axios";
import { useNavigate } from 'react-router-dom';

function Table() {
    const navigate = useNavigate();

    const [book, setBook] = useState();

    useEffect(() => {
        axios.get('http://localhost:8085/api/books')
            .then((response) => {

                setBook(response.data)

            })
            .catch((err) => {
                console.error("ops! ocorreu um erro" + err);

            })
    }, [])

    const deleteBook = (id) => {


        axios.delete(`http://localhost:8085/api/books/${id}`).then((response) => {

            console.log(response);
            setBook(book.filter(item => item.id !== id));
        });


    }




    const columns = [
        {
            name: 'Título',
            selector: row => row.title,
        },
        {
            name: 'Autor',
            selector: row => row.author,
        },
        {
            name: 'Categoria',
            selector: row => row.categoryName,
        },
        {
            name: 'Ações',
            selector: row => row.action,


            cell: row => <div className="flex gap-5">
                <button onClick={() => navigate(`/cadastro-livros/${row.id}`)}>  <FontAwesomeIcon icon={faEdit} /></button>


                <button onClick={() => deleteBook(row.id)}>  <FontAwesomeIcon icon={faTrash} /></button>
            </div>
        }
    ];




    // const books = [
    //     { id: 1, title: 'Livro 3', author: 'Autor 1', category: 'Categoria 1' },
    //     { id: 2, title: 'Livro 2', author: 'Autor 2', category: 'Categoria 2' },
    //     { id: 3, title: 'Livro 3', author: 'Autor 3', category: 'Categoria 3' },
    // ];


    return (
        <DataTable
            columns={columns}
            data={book}
            pagination
        />
    )
}



export default Table
