import React from 'react'
import ReactDOM from 'react-dom/client'
import './styles/global.css'
import { Home } from './Pages/Home'
import {BrowserRouter,Routes,Route} from 'react-router-dom'
import FormStep1 from './Pages/FormStep1'
import { FormStep2 } from './Pages/FormStep2'
import { FormStep3 } from './Pages/FormStep3'
import{useForm,FormActions} from './Contexts/FormContext'

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<FormStep1 />}/>
        <Route path='/step2' element={<FormStep2 />}/>
        <Route path='/step3' element={<FormStep3 />}/>
      </Routes>
    </BrowserRouter>
  </React.StrictMode>,
)
