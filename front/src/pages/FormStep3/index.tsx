import { Theme } from '../../components/Theme';
import { Link, useNavigate, } from 'react-router-dom';
import * as C from './styles';



export const FormStep3 = () => {
    const history = useNavigate(); 
   

    const handleSave = ()=>{
        history('/step1')
     }
     const handleDownload = ()=>{
        
        
    }

    return( 
        <Theme>
        <C.Container>
        <p>Passo 3/3 </p>
             <h1> Vamos Começar Salvar e imprimir seu Contrato</h1>
             <p>Seguir passos Savar - Imprimir</p>
             <hr/>
             <Link to="/step2" className='backbutton'>Voltar</Link>
             <button onClick={handleSave}>Salvar</button>
             <button className='btn_danger' onClick={handleDownload}> Download PDF</button> 
       </C.Container>
        </Theme>
    );

   
}