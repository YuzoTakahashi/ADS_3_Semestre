const root = window.document.getElementById("root");

function Titulo(props) {
    return (
        <h1>{ props.suaMae }</h1>
    );
}

function H1(){
    return <h1>TESTE H1</h1>
}

function Titulos() {
    return (
        <div>
            <Titulo texto="teste"/>
            <Titulo texto="mundo"/>
            <Titulo suaMae="suaMae"/>
            <H1 />
        </div>
    )
}

ReactDOM.createRoot(root).render(
    <Titulos />
);