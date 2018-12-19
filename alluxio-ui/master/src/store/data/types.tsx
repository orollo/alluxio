import {IUiFileInfo} from '../../constants';

export interface IData {
  'fatalError': string;
  'fileInfos': IUiFileInfo[],
  'inAlluxioFileNum': number;
  'masterNodeAddress': string;
  'permissionError': string;
  'showPermissions': boolean;
}

export const enum DataActionTypes {
  FETCH_REQUEST = '@@data/FETCH_REQUEST',
  FETCH_SUCCESS = '@@data/FETCH_SUCCESS',
  FETCH_ERROR = '@@data/FETCH_ERROR'
}

export interface IDataState {
  readonly loading: boolean;
  readonly data: IData;
  readonly errors?: string;
}
