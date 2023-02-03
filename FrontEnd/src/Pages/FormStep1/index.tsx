import {useNavigate} from 'react-router-dom'
import * as C from './styles';
import {useForm, FormActions} from '../../Contexts/FormContext'
import {Theme} from '../../components/Theme'



const FormStep1 = () => {
    const history = useNavigate(); 
   // const {state, dispatch} = useForm();

    const handleNextStep = ()=>{
        history('/step2')  
    }
    return(
       
        <Theme>
            <C.Container>
             <p>Passo 1/3 </p>
             <h1> Vamos Começar com os dados da Empresa Contrata</h1>
             <p>Preencha os campos abaixo</p>
             <hr/>

             <label>
                Nome da Empresa
                <input
                 type="text"
                 autoFocus
               //  value={state.RazaoSocialContratada}
                />
             </label>
             <hr/>
             <label>
                Nome Fantasia
                <input
                 type="text"
              //   value={state.nomeFantasiaContratada}
                />
             </label>
             <hr/>
             <label>
                Logradouro
                <input
                 type="text"
               //  value={state.LogradouroContratada}
                />
             </label>
             <hr/>
             <label>
                Bairro
                <input
                 type="text"
              //   value={state.BairroContratada}
                />
             </label>
             <hr/>
             <label>
                cidade
                <input
                 type="text"
              //   value={state.CidadeContratada}
                />
             </label>
             <hr/>
             <label>
                Estado
                <input
                 type="text"
             //    value={state.EstadoContratada}
                />
             </label>
             <hr/>
             <label>
                Cep
                <input
                 type="text"
             //    value={state.CepContratada}
                />
             </label>
             <hr/>
             <label>
                Faturamento 
                <input
                 type="number"
                // value={state.FaturamentoContratada}
                />
             </label>
             <hr/>
             <label>
                Numero de Lojas
                <input
                 type="number"
               //  value={state.NumeroLojas}
                />
             </label>
             <button onClick={handleNextStep}>Proximo</button>
            </C.Container>
        </Theme>
    );
}

export default FormStep1;