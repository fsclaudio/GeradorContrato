
import {useNavigate} from 'react-router-dom'
import * as A from './styles';
import {useForm, FormActions} from '../../Contexts/FormContext'
import {Theme} from '../../components/Theme'
import { ChangeEvent, useEffect } from 'react';



const FormStep1 = () => {
    const history = useNavigate(); 
    const {state, dispatch} = useForm();

    useEffect(()=>{
        dispatch({
            type: FormActions.setCurretStep,
            payload: 1
        })
    })
    const handleNextStep = ()=>{
        if(state.RazaoSocialContratada!== '' && state.nomeFantasiaContratada!== ''
        && state.LogradouroContratada!== ''  && state.BairroContratada!== ''
        && state.CidadeContratada!== ''      && state.EstadoContratada!== ''
        && state.CepContratada!== ''         && state.FaturamentoContratada!== 0 
        && state.NumeroLojas!== 0){
            history('/step2')  
        } else{
            alert("Preencha os dados do formulario!")
        }
       
    }

    const handleRazaoSocialContratada = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setRazaoSocialContratada,
            payload: e.target.value
        })
    }
    const handleNomeFantasiaContratada = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setnomeFantasiaContratada,
            payload: e.target.value
        })
    }

    const handleLogradouroContratada = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setLogradouroContratada,
            payload: e.target.value
        })
    }
    const handleBairroContratada = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setBairroContratada,
            payload: e.target.value
        })
    }
    const handleCidadeContratada = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setCidadeContratada,
            payload: e.target.value
        })
    }
    const handleEstadoContratada = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setEstadoContratada,
            payload: e.target.value
        })
    }
    const handleCepContratada = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setCepContratada,
            payload: e.target.value
        })
    }
    const handleFaturaContratada = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setFaturamentoContratada,
            payload: e.target.value
        })
    }
    const handleNumeroLojasContratada = (e: ChangeEvent<HTMLInputElement>)=>{
        dispatch({
            type: FormActions.setNumeroLojas,
            payload: e.target.value
        })
    }

    return(
       
        <Theme>
            <A.Container>
             <p>Passo 1/3   </p>
             <h1> Vamos Começar com os dados da Empresa Contrata</h1>
             <p>Preencha os campos abaixo</p>
             <hr/>

             <label>
                Nome da Empresa
                <input
                 type="text"
                 autoFocus
                 value={state.RazaoSocialContratada}
                 onChange={handleRazaoSocialContratada}
                />
             </label>
             <hr/>
             <label>
                Nome Fantasia
                <input
                 type="text"
                 value={state.nomeFantasiaContratada}
                 onChange ={handleNomeFantasiaContratada}
                />
             </label>
             <hr/>
             <label>
                Logradouro
                <input
                 type="text"
                 value={state.LogradouroContratada}
                 onChange ={handleLogradouroContratada}
                />
             </label>
             <hr/>
             <label>
                Bairro
                <input
                 type="text"
                 value={state.BairroContratada}
                 onChange ={handleBairroContratada}
                />
             </label>
             <hr/>
             <label>
                cidade
                <input
                 type="text"
                 value={state.CidadeContratada}
                 onChange ={handleCidadeContratada}
                />
             </label>
             <hr/>
             <label>
                Estado
                <input
                 type="text"
                 value={state.EstadoContratada}
                 onChange ={handleEstadoContratada}
                />
             </label>
             <hr/>
             <label>
                Cep
                <input
                 type="text"
                 value={state.CepContratada}
                 onChange ={handleCepContratada}
                />
             </label>
             <hr/>
             <label>
                Faturamento 
                <input
                 type="number"
                 value={state.FaturamentoContratada}
                 onChange ={handleFaturaContratada}
                />
             </label>
             <hr/>
             <label>
                Numero de Lojas
                <input
                 type="number"
                 value={state.NumeroLojas}
                 onChange ={handleNumeroLojasContratada}
                />
             </label>
             <button onClick={handleNextStep}>Proximo</button>
            </A.Container>
        </Theme>
    );
}

export default FormStep1;