package model;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import view.display.main.form.SearcherForm;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

import model.objects.Record;

public class JTableDownloadTemplate extends AbstractTableModel {
    private List<Record> dwnloadList =new ArrayList<>();
    private Disposable subscription;

    public void starter(){
        Observable<Record> recordObservable = createRecordObservable();
        subscription = recordObservable.subscribe(
                this::onRecordUpdate, //onNExt
                Throwable::printStackTrace
        );
    }

    private void onRecordUpdate(Record record) {
        if(!SearcherForm.getSearchResult().isEmpty()){
            int index = SearcherForm.getSearchResult().indexOf(record);
            if(index >=0){
                //Fire table row update notification to table
                fireTableRowsUpdated(index, index);
            }
        }
    }

    public void dispose(){
        if(subscription != null && !subscription.isDisposed()){
            subscription.dispose();
        }
    }

    private void onRecordUpdate() {
        if(SearcherForm.getSearchResult().isEmpty()){
            System.out.println("Empty List - No selection");
        }
    }

    private Observable<Record> createRecordObservable() {
        //Implements Observable that emits Records when thy are selected
        //PulishSubject<Record> and calling onNext when ocurrs.
        return null;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
