import { PipeTransform, Pipe } from '@angular/core';
import { Tecnico } from '../modelo/tecnico.model';

@Pipe({
    name: 'filtroPorNome'
})
export class TecnicoFilterPipe implements PipeTransform {
    transform(tecnicos: Tecnico[], pesquisar: string): Tecnico[] {
        if (!tecnicos || !pesquisar) {
            return tecnicos;
        }

        return tecnicos.filter(tecnico =>
            tecnico.nomecompleto.toLowerCase().indexOf(pesquisar.toLowerCase()) !== -1);
    }
}
