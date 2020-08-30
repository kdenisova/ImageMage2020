import React, {Component} from 'react';
import './App.css';

interface AppProps {
}

interface AppState {
    counter: number;
    w: number;
}

export class App extends Component<AppProps, AppState> {

    state: AppState = {
        counter: 0,
        w: 100
    };

    private async callApi(): Promise<any> {
        const response = await fetch("http://localhost:8080/api/img/5");
        const data = await response.json();
        this.imageLocation = data.url;
        this.setState({ counter: this.state.counter + 1 });
    }

    imageLocation: string = '';
    h: number = 100;

    public render() {
        return (
            <div className="App">
                <button onClick={() => this.callApi()}>Click me please!</button>
                <button onClick={() => { this.setState({ w: this.state.w += 50 }); this.h += 50; }}>bigger</button>
                <button onClick={() => { this.setState({ w: this.state.w -= 50 }); this.h -= 50; }}>smaller</button>
                <span>{this.state.counter}</span>
                <div>
                    <img src={this.imageLocation} width={this.state.w} height={this.h} alt={"sorry, not image has been loaded"}/>
                </div>
            </div>
        );
    }
}

export default App;
