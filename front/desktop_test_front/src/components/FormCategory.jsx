import { useEffect, useState } from "react";
import axios from 'axios';



function FormCategory() {



    const [name, setName] = useState('');
    const [description, setDescription] = useState('');





    const post = (event) => {
        event.preventDefault();
        const data = {
            name: name,
            description: description,

        }

        axios.post('http://localhost:8085/api/categories/save', data).then((response) => {

            console.log(response);
        });


    }



    return (

        <form class="max-w-md mx-auto">
            <div class="sm:col-span-2">
                <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Titulo</label>
                <input type="text" value={name} onChange={(e) => { setName(e.target.value) }} name="name" id="name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" placeholder="Nome" required="" />
            </div>
            <div class="w-full">
                <label for="brand" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Autor</label>
                <input type="text" value={description} onChange={(e) => { setDescription(e.target.value) }} name="brand" id="brand" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" placeholder="Descrição" required="" />
            </div>
            <br />


            <button type="submit" onClick={post} class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Enviar</button>
        </form>

    )
}

export default FormCategory



