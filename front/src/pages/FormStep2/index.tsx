import { useNavigate, Link } from 'react-router-dom';
import {useForm, FormActions} from '../../Contexts/FormContext';
import { Theme } from '../../components/Theme';
import * as C from './styles';
import { ChangeEvent, useEffect } from 'react';

export const FormStep2 = () => {
    const history = useNavigate(); 
    const {state, dispatch} = useForm();
 
    useEffect(()=>{
        dispatch({
            type: FormActions.setCurretStep,
            payload: 2
        })
    })
     const handleNextStep = ()=>{
        if(state.RazaoSocialContratante!== '' && state.NomeFantasiaContratante!== ''
        && state.LogradouroContratante!== ''  && state.BairroContratante!== ''
        && state.CidadeContratante!== ''      && state.EstadoContratante!== ''
        && state.CepContratante!== '' ){
            history('/step3')  
        } else{
            alert("Preencha os dados do formulario!")
        }  
     }
     const handleRazaoSocialContratante = (e: ChangeEvent <HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setRazaoSocialContratante,
            payload: e.target.value
        })
    }
    const handleNomeFantasiaContratante = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setNomeFantasiaContratante,
            payload: e.target.value
        })
    }

    const handleLogradouroContratante = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setLogradouroContratante,
            payload: e.target.value
        })
    }
    const handleBairroContratante = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setBairroContratante,
            payload: e.target.value
        })
    }
    const handleCidadeContratante = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setCidadeContratante,
            payload: e.target.value
        })
    }
    const handleEstadoContratante = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setEstadoContratante,
            payload: e.target.value
        })
    }
    const handleCepContratante = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setCepContratante,
            payload: e.target.value
        })
    }
    return(
        <Theme>
        <C.Container>
        <p>Passo 2/3 </p>
             <h1> Vamos Começar com os dados da Empresa Contratante</h1>
             <p>Preencha os campos abaixo</p>
             <hr/>

             <label>
                Nome da Empresa
                <input
                 type="text"
                 autoFocus
                 value={state.RazaoSocialContratante}
                 onChange={handleRazaoSocialContratante}
                />
             </label>
             <hr/>
             <label>
                Nome Fantasia
                <input
                 type="text"
                 value={state.NomeFantasiaContratante}
                 onChange={handleNomeFantasiaContratante}
                />
             </label>
             <hr/>
             <label>
                Logradouro
                <input
                 type="text"
                 value={state.LogradouroContratante}
                 onChange={handleLogradouroContratante}
                />
             </label>
             <hr/>
             <label>
                Bairro
                <input
                 type="text"
                 value={state.BairroContratante}
                 onChange={handleBairroContratante}
                />
             </label>
             <hr/>
             <label>
                cidade
                <input
                 type="text"
                 value={state.CidadeContratante}
                 onChange={handleCidadeContratante}
                />
             </label>
             <hr/>
             <label>
                Estado
                <input
                 type="text"
                 value={state.EstadoContratante}
                 onChange={handleEstadoContratante}
                />
             </label>
             <hr/>
             <label>
                Cep
                <input
                 type="text"
                 value={state.CepContratante}
                 onChange={handleCepContratante}
                />
             </label>

             <Link to="/" className='backbutton'>Voltar</Link>
             <button onClick={handleNextStep}>Proximo</button> 
       </C.Container>
        </Theme>
      
    );
}