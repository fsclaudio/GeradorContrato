import {createContext, ReactNode, useContext, useReducer} from 'react'

type Action = {
    type: FormActions;
    payload: any;
}
type State = {
    CurretStep: number;
    RazaoSocialContratada: string;
    nomeFantasiaContratada: string;
    CnpjContratada: string;
    LogradouroContratada: string;
    BairroContratada: string;
    CidadeContratada: string;
    EstadoContratada: string;
    CepContratada: string;
    FaturamentoContratada: number;
    NumeroLojas: number;
    RazaoSocialContratante: string;
    NomeFantasiaContratante: string;
    CnpjContratante: string;
    LogradouroContratante: string;
    BairroContratante: string;
    CidadeContratante: string;
    EstadoContratante: string;
    CepContratante: string;
    NumeroParcelas: string;  
}

type ContextType ={
    state: State;
    dispatch: (action: Action) => void;
} 

type FormProvideProps = {
    children: ReactNode;
}

const initialData: State = {
    CurretStep: 0,
    RazaoSocialContratada: '',
    nomeFantasiaContratada: '',
    CnpjContratada: '',
    LogradouroContratada: '',
    BairroContratada: '',
    CidadeContratada: '',
    EstadoContratada: '',
    CepContratada: '',
    FaturamentoContratada: 0,
    NumeroLojas: 0,
    RazaoSocialContratante: '',
    NomeFantasiaContratante: '',
    CnpjContratante: '',
    LogradouroContratante: '',
    BairroContratante: '',
    CidadeContratante: '',
    EstadoContratante: '',
    CepContratante: '',
    NumeroParcelas: '',
}


// context
const FormContext = createContext<ContextType | undefined>(undefined);

//reducer
export enum FormActions {
    setCurretStep,
    setRazaoSocialContratada,
    setnomeFantasiaContratada,
    setCnpjContratada,
    setLogradouroContratada,
    setBairroContratada,
    setCidadeContratada,
    setEstadoContratada,
    setCepContratada,
    setFaturamentoContratada,
    setNumeroLojas,
    setRazaoSocialContratante,
    setNomeFantasiaContratante,
    setCnpjContratante,
    setLogradouroContratante,
    setBairroContratante,
    setCidadeContratante,
    setEstadoContratante,
    setCepContratante,
    setNumeroParcelas

}
const formReducer = (state: State, action: Action )=>{
    switch (action.type) {
        case FormActions.setCurretStep:
            return {...state, currentStep: action.payload}; 
        case FormActions.setRazaoSocialContratada:
            return {...state, RazaoSocialContratada: action.payload}; 
        case FormActions.setnomeFantasiaContratada:
            return {...state, nomeFantasiaContratada: action.payload}; 
        case FormActions.setCnpjContratada:
            return {...state, CnpjContratada: action.payload}; 
        case FormActions.setLogradouroContratada:
            return {...state, LogradouroContratada: action.payload}; 
        case FormActions.setBairroContratada:
            return {...state, BairroContratada: action.payload}; 
        case FormActions.setCidadeContratada:
            return {...state, CidadeContratada: action.payload}; 
        case FormActions.setEstadoContratada:
            return {...state, EstadoContratada: action.payload}; 
        case FormActions.setCepContratada:
            return {...state, CepContratada: action.payload}; 
        case FormActions.setFaturamentoContratada:
            return {...state, FaturamentoContratada: action.payload}; 
        case FormActions.setNumeroLojas:
            return {...state, NumeroLojas: action.payload}; 
        case FormActions.setRazaoSocialContratante:
            return {...state, RazaoSocialContratante: action.payload}; 
        case FormActions.setNomeFantasiaContratante:
            return {...state, NomeFantasiaContratante: action.payload}; 
        case FormActions.setCnpjContratante:
            return {...state, CnpjContratante: action.payload}; 
        case FormActions.setLogradouroContratante:
            return {...state, LogradouroContratante: action.payload}; 
        case FormActions.setBairroContratante:
            return {...state, BairroContratante: action.payload}; 
        case FormActions.setCidadeContratante:
            return {...state,  CidadeContratante: action.payload}; 
        case FormActions.setEstadoContratante:
            return {...state, EstadoContratante: action.payload}; 
        case FormActions.setCepContratante:
            return {...state, CepContratante: action.payload}; 
        case FormActions.setNumeroParcelas:
            return {...state, NumeroParcelas: action.payload};  
        default:
            return state;                                                                 
    }
}

// provider

export const FormProvider = ({children}: FormProvideProps) =>{
    const [state,dispatch] = useReducer(formReducer,initialData);
    const value = {state,dispatch}
    return(
        <FormContext.Provider value={value}>
            {children}
        </FormContext.Provider>
    )
}

// context hook
export const useForm = () =>{
    const context = useContext(FormContext);
    if (context=== undefined){
        throw new Error('UseForm precisa esta dentro do formProvider');
    }
    return context;
}
