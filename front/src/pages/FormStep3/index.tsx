import { Theme } from '../../components/Theme';
import { Link, useNavigate, } from 'react-router-dom';
import * as C from './styles';
import pdfMake from "pdfmake/build/pdfmake";
import {useForm} from '../../Contexts/FormContext'
import vfs from "pdfmake/build/vfs_fonts";
import { TDocumentDefinitions } from 'pdfmake/interfaces';



export const FormStep3 = () => {
    const history = useNavigate(); 
    const {state} = useForm();

    const handleSave = ()=>{
        history('/step1')
     }
     
     const handleDownload = ()=>{
        pdfMake.vfs = vfs.pdfMake.vfs;

        const reportTitle = [
            'CONTRATO PAAS (CASHContratos) Nº 01 ',
            
   ];

        const details = ['Pelo presente instrumento particular de Contrato de Licenciamento de uso de Software, na modalidade PaaS (Plataforma como Serviço), na melhor forma de direito fazem entre si:',
     '(A)', state.BairroContratada, 'sociedade limitada, inscrita no Cadastro Nacional de Pessoas Jurídicas do Ministério da Fazenda (“CNPJ/MF”) sob o n°', state.CnpjContratada,', com sede na'
      ,state.LogradouroContratada,' na Cidade de', state.CidadeContratada, 'e Estado de',state.EstadoContratada,' CEP', state.CepContratada,' inscrita no CNPJ/MF sob nº', state.CnpjContratada,
      ', neste ato representada na forma do seu Contrato Social', state.nomeFantasiaContratada,];

       const rodape = ['page=' + 1]

        const docDefinitions: TDocumentDefinitions = {
            pageSize: 'A4',
            pageMargins: [15,50,15,40],

            header:[reportTitle],
            content: [details],
            footer: [rodape]
        }

        pdfMake.createPdf(docDefinitions).download();
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