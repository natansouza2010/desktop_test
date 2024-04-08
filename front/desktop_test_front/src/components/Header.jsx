import { Link } from 'react-router-dom'



function Header() {




    return (
        <header class="bg-gray-800 text-white py-4 p-20">
            <div class="container mx-auto flex justify-between items-center p-5">
                <h1 class="text-2xl font-bold">Sistema de Gerenciamento de Livros</h1>
                <nav>
                    <ul class="flex space-x-4">
                        <li><a href="/" class="hover:text-gray-300">Inicio</a></li>
                        <li><a href="/cadastro-livros" class="hover:text-gray-300">Cadastro de Livros</a></li>
                        <li><a href="/cadastro-categorias" class="hover:text-gray-300">Cadastro de Categorias</a></li>
                    </ul>
                </nav>
            </div>
        </header>
    )
}



export default Header
